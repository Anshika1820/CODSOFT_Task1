# Task 1: Number Game
* Introduction-
    The Number Game project is an interactive desktop application developed using Java Swing. It is a simple guessing game where the system generates a random 
    number between 1 and 100, and the player has to guess the correct number within five attempts. The game provides hints based on how close the guess is to the 
    target number. This project demonstrates concepts like GUI development in Java, event-driven programming, random number generation, and logical decision- 
    making using conditions.

* Project Overview-
  
1️⃣ Graphical User Interface (GUI) Design-
    The entire application is built using Java Swing components. The main GUI consists of:
    A JFrame as the main window.
    A JPanel for holding the game components.
    Multiple JLabels for displaying text and messages.
    A JTextField for user input.
    Two JButtons:
       1. GUESS button to submit a guess.
       2. Play Again button to restart the game.
    Layout Management:
       The JFrame uses BorderLayout to divide the window into sections:
            NORTH region for the game title.
            CENTER region for the panel containing game components.
    The JPanel uses a BoxLayout (Vertical arrangement) to stack components like labels, text fields, and buttons.
    This structure ensures a clean, centered layout where all components are neatly aligned in the window.

2️⃣ Core Components and Their Purpose
Component	Role-
   JFrame	Main application window that contains all components.
   JPanel	Container to hold labels, text fields, and buttons.
   JLabel	Displays static text like instructions, feedback messages, and hints.
   JTextField	Allows the user to input their guessed number.
   JButton	Provides interactive buttons for submitting guesses and starting new rounds.
   Box.createRigidArea	Adds vertical space between components for better visual spacing.

3️⃣ Game Logic Implementation
a) Random Number Generation-
   A random number is generated between 1 and 100 using:
           num = (int) (Math.random() * 100) + 1;
   This random number remains constant for a game round until the user guesses correctly or exhausts the attempts.

b) Guess Validation & Hints-
   When the GUESS button is clicked, the program:
         Reads the user’s guess from the text field.
         Compares it with the generated number.
         Calculates the difference (diff) between the guess and the actual number.
         Provides feedback based on the closeness:
              Exact Match: “Your Guess is correct!!!!” (green text, game won).
              Within 5: “You are too close to the number!!!!”
              Within 10: “You are close to the number!!!!”
              Within 20: “You are far from the number!!!!”
              Else: “You are way too far from the number!!!!”
    After each guess, the program updates the remaining attempts and disables the text field if all 5 attempts are used.
    If the user guesses correctly, a JOptionPane popup congratulates the player.

c) Restarting the Game-
   The Play Again button resets the game:
       Generates a new random number.
       Resets the attempt counter.
       Clears previous feedback.
       Re-enables the text field for new guesses.

4️⃣ Event Handling-
    The application uses Action Listeners to handle button clicks:
        btn.addActionListener(e -> guess()); for the GUESS button.
        btnAgain.addActionListener(e -> number()); for the Play Again button.
    Each listener triggers a corresponding method that updates the game logic and GUI.

5️⃣ Error Handling
    The game handles invalid inputs (like letters or special characters) using a try-catch block:
       try {
           guessnum = Integer.parseInt(guessNum.getText().trim());
       } catch (NumberFormatException e) {
           lbl9.setText("Invalid input...Enter a number!!!");
       }  
    If the input is invalid, a red warning message appears, and the game does not crash.

6️⃣ Styling and Visuals
    Background color: Black for frame and panel.
    Text colors:
       Yellow for main labels and hints.
       White for dynamic messages.
       Green for success messages.
       Red for warnings and errors.
    Font: Verdana, bold, with varying sizes for different components.
    Buttons: Yellow background with black text for high visibility.

* Features Summary
   Random number generation (1-100).
   5 attempts per game.
   Hints based on guess proximity.
   Input validation and error handling.
   "Play Again" button for restarting the game.
   Neat GUI layout using BoxLayout.
   Color-coded feedback for better UX.
   Congratulations popup for correct guesses.

* Concepts Applied
Java Swing components (JFrame, JPanel, JLabel, JTextField, JButton).
Layout Management: BorderLayout, BoxLayout.
Event Handling: ActionListener.
Random Number Generation: Math.random().
Conditionals & Logical Operators.
Exception Handling: try-catch for input validation.
------------------------------------------------------------------------------------------------------------------------------------------------------------------
