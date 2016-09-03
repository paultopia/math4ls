(ns montyhall.core
  (:require [reagent.core :as reagent :refer [atom]]
            [b1.charts :as c]
            [b1.svg :as svg]))

;; -------------------------
;; Views

(def data (atom (take 100 (repeatedly rand))))

(defn more-data [] (reset! data (take 100 (repeatedly rand))))

(defn hist [sample]
  (-> (c/histogram sample :x-axis [0 1] :n-bins 30)
      (svg/as-svg :width 500 :height 200)))

;; looks like b1 doesn't actually honor n-bins, making it useless.  raw svg?

(def win 509)
(def loss 208)

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
    [wl-chart win loss]]])

;; -------------------------
;; Initialize app

(defn mount-root []
  (reagent/render [home-page] (.getElementById js/document "app")))

(defn init! []
  (mount-root))
