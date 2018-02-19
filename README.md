# gppredictor
Modified 19.2.2018

GP Predictor score calculating application

Background:
GP Predictor is a website where you can register yourself and compete with your friends by making predictions for
each Formula One Grand Prix during a F1 season. The service calculates the points the next day after the race when the
official results come in, but sometimes point calculation takes even longer than that.

I decided to make a small application using Java where you can give your predictions and the race results as input.
The application will then calculate the points you will receive instantly. Currently the application prompts the race
predictions and results from the user. The aim is to make this application better in the future by:
    1. Giving the option to provide both results and predictions as parameters in JSON format
    2. To perhaps make this part of a RESTful web service (learning at the same time myself)

Rules:
The player gives predictions for the following:
    1. Top ten finished drivers in the GP
    2. Drivers with the fastest lap and most positions gained in the GP, and the driver gaining pole position in the
        Qualifications

For each correctly predicted driver in the top ten results, the player scores 10 points.
However, the player scores 20 points instead of 10 by predicting the winner of the GP (1st position) correctly.
For each driver the player misses by one position, the player scores 5 points.
For each driver the player misses by two positions, the player scores 2 points.
Additionally, the player receives 100 bonus points for predicting all positions correctly, 60 bonus points for
predicting 6 - 9 positions correctly, and 30 bonus points for predicting the top three positions correctly.
For each correctly predicted race event (pole position, fastest lap, positions gained), the player scores 5 points.
By correctly predicting all three race events, the player scores 30 bonus points.