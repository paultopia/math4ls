(ns montyhall.core
  (:require [reagent.core :as reagent :refer [atom]]))



(def win (atom 0))
(def loss (atom 0))

(defn find-remaining
  "Simulates opening (and thus eliminating) one of the goat doors, and
  returns the remaining closed door, which player can switch to.

  If player's first guess is goat, open other goat door, and return car as last
  closed door.  If player's first guess is car, open one of the two goat doors and return other goat door as last closed door. "
  [first-guess]
  (if (= first-guess :car) :goat :car))

(defn apply-strategy [strategy first-guess remaining]
  (case strategy
    :stubborn first-guess
    :switcher remaining
    :random (rand-nth [first-guess remaining])))

(defn play-monty [strategy]
  (let [first-guess (rand-nth [:goat :goat :car])
        remaining (find-remaining first-guess)
        result (apply-strategy strategy first-guess remaining)]
    (cond
      (= result :car) (swap! win inc)
      :else (swap! loss inc))))

(defn wl-chart [w l]
  (let [win-ratio (* 200 (/ w (+ w l)))
        lose-ratio (- 200 win-ratio)]
    [:div
    [:svg {:class "chart" :width 150 :height 210}
     [:g {:transform "translate(0,0)"}
      [:rect {:width 30 :height win-ratio :y lose-ratio}]
      [:text {:y 210 :x 20} "win"]]
     [:g {:transform "translate(35,0)"}
      [:rect {:width 30 :height lose-ratio :y win-ratio}]
      [:text {:y 210 :x 25} "loss"]]]
     [:p (str "wins: " w)]
     [:p (str " losses: " l)]]))


(defn home-page []
  [:div
   [:p "test"]
   [:div
    [wl-chart @win @loss]]
   [:button {:on-click #(play-monty :stubborn)} "shuffle"]])

;; -------------------------
;; Initialize app

(defn mount-root []
  (reagent/render [home-page] (.getElementById js/document "app")))

(defn init! []
  (mount-root))
