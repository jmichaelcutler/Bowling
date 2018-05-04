This program parses a string input representing a <U>complete</U> game of bowling and returns the total score resulting from the game, including bonuses for strikes, spares, and bonus balls.  The program requires Java 8, and can be run by typing the following command in the command line:

     BowlingScorer <input>

Rules and examples of valid input:

* X indicates a strike
* / indicates a spare
* \- indicates a miss
* | indicates a frame boundary
* The characters after the || indicate bonus balls

X|X|X|X|X|X|X|X|X|X||XX

* Ten strikes on the first ball of all ten frames.
* Two bonus balls, both strikes.


9-|9-|9-|9-|9-|9-|9-|9-|9-|9-||

* Nine pins hit on the first ball of all ten frames.
* Second ball of each frame misses last remaining pin.
* No bonus balls.

5/|5/|5/|5/|5/|5/|5/|5/|5/|5/||5
* Five pins on the first ball of all ten frames.
* Second ball of each frame hits all five remaining
pins, a spare.
* One bonus ball, hits five pins.


X|7/|9-|X|-8|8/|-6|X|X|X||81

If no string is given, the program will return 0.

If a partial game (0 < number of frames < 10) is given, an error will be thrown.

Also, an error will be thrown if invalid characters are detected, or if an incorrectly-scored frame is detected.
