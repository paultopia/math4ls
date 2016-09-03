(ns montyhall.core
  (:require [reagent.core :as reagent :refer [atom]]
            [b1.charts :as c]
            [b1.svg :as svg]))

;; -------------------------
;; Views

(def data (atom (take 100 (repeatedly rand))))

(defn more-data [] (reset! data (take 100 (repeatedly rand))))

(defn hist [sample]
  (-> (c/histogram sample :x-axis [0 1] :n-bins 10)
      (svg/as-svg :width 500 :height 200)))

(defn home-page []
  [:div [:h2 "Welcome to Reagent"]
   [hist @data]
   [:button {:on-click more-data} "More data"]])

;; -------------------------
;; Initialize app

(defn mount-root []
  (reagent/render [home-page] (.getElementById js/document "app")))

(defn init! []
  (mount-root))
