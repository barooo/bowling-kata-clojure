(ns bowling-kata.core)

(defn spare? [rolls]
  (and (> (count rolls) 1) 
       (= 10 (+ (first rolls) (second rolls)))))

(defn strike? [rolls]
  (and (= 10 (first rolls)) 
       (> (count rolls) 2)))

(defn last-frame? [rolls]
  (or (= 2 (count rolls))
      (and (= 3 (count rolls)) 
	   (or (strike? rolls) (spare? rolls)))))

(defn balls-to-score [rolls]
  (if (or (strike? rolls) (spare? rolls)) 3 2))
 
(defn balls-in-frame [rolls]
  (if (last-frame? rolls)
    (if (or (strike? rolls) (spare? rolls)) 3 2)
    (if (strike? rolls) 1 2)))
  
(defn score-frame [rolls]
  (reduce + (take (balls-to-score rolls) rolls)))

(defn advance-frame [rolls]
  (drop (balls-in-frame rolls) rolls))

(defn score-game [rolls]
  (loop [score 0 balls rolls]
    (if (empty? balls) score
	(recur (+ score (score-frame balls)) 
	       (advance-frame balls)))))
