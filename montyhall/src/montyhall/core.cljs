(ns montyhall.core
  (:require [reagent.core :as reagent :refer [atom]]))



(def win-stubborn (atom 0))
(def loss-stubborn (atom 0))

(def win-switcher (atom 0))
(def loss-switcher (atom 0))

(def win-random (atom 0))
(def loss-random (atom 0))


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

(defn play-monty [strategy win-atom loss-atom]
  (let [first-guess (rand-nth [:goat :goat :car])
        remaining (find-remaining first-guess)
        result (apply-strategy strategy first-guess remaining)]
    (cond
      (= result :car) (swap! win-atom inc)
      :else (swap! loss-atom inc))))

(defn lotsa-monty [strategy win-atom loss-atom]
  (do
    (reset! win-atom 0)
    (reset! loss-atom 0)
    (dotimes [n 10000]
      (js/setTimeout #(play-monty strategy win-atom loss-atom) n))))

(defn wl-chart [w l caption]
  (let [win-ratio (* 200 (/ w (+ w l)))
        lose-ratio (- 200 win-ratio)]
    [:div
     [:figure
      [:figcaption (str caption ": win: " w " loss: " l)]
      [:svg {:class "chart" :width 150 :height 210}
       [:g {:transform "translate(0,0)"}
        [:rect {:width 30 :height win-ratio :y lose-ratio}]
        [:text {:y 210 :x 20} "win"]]
       [:g {:transform "translate(35,0)"}
        [:rect {:width 30 :height lose-ratio :y win-ratio}]
        [:text {:y 210 :x 25} "loss"]]]]]))


(defn home-page []
  [:div
   [:div
    [wl-chart @win-stubborn @loss-stubborn "Stubborn"]]
   [:button {:on-click #(lotsa-monty :stubborn win-stubborn loss-stubborn)} "Play Stubborn Strategy"]
   [:div
    [wl-chart @win-switcher @loss-switcher "Switcher"]]
   [:button {:on-click #(lotsa-monty :switcher win-switcher loss-switcher)} "Play Switcher Strategy"]
   [:div
    [wl-chart @win-random @loss-random "Random"]]
   [:button {:on-click #(lotsa-monty :stubborn win-random loss-random)} "Play Random Strategy"]
])

;; -------------------------
;; Initialize app

(defn mount-root []
  (reagent/render [home-page] (.getElementById js/document "app")))

(defn init! []
  (mount-root))
