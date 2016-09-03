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

(defn svg-test []
  [:svg {:x 0 :y 0 :width 50 :height 50}
   [:rect {:x 10 :y 10 :width 1000 :height 10}]])

(defn svg-bar-chart []
  [:svg {:class "chart" :width 150 :height 210}
   [:g {:transform "translate(0,0)"}
    [:rect {:width 30 :height 160 :y 40}]
    [:text {:y 210 :x 20} "win"]]
   [:g {:transform "translate(35,0)"}
    [:rect {:width 30 :height 80 :y 120}]
    [:text {:y 210 :x 25} "loss"]]])

(defn home-page []
  [:div [:h2 "graph me"]
   ;; [hist @data]
   ;; [:button {:on-click more-data} "More data"]
   ;; [:div
   ;;  [svg-test]]
   [svg-bar-chart]
   [svg-bar-chart]
   ])

;; -------------------------
;; Initialize app

(defn mount-root []
  (reagent/render [home-page] (.getElementById js/document "app")))

(defn init! []
  (mount-root))
