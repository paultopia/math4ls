(ns montyhall.core
  (:require [reagent.core :as reagent :refer [atom]]))



(def win (atom 0))
(def loss (atom 0))

(defn play-monty []
  (do
    (reset! win (rand-int 1000))
    (reset! loss (rand-int 100))))

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
   [:button {:on-click play-monty} "shuffle"]])

;; -------------------------
;; Initialize app

(defn mount-root []
  (reagent/render [home-page] (.getElementById js/document "app")))

(defn init! []
  (mount-root))
