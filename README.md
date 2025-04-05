
```markdown
 Basic Calculator App  Kotlin for Android

 Overview

This is a simple calculator app developed using Kotlin for Android. The app allows users to perform basic arithmetic operations, such as addition, subtraction, multiplication, and division. It includes features like a backspace button, allclear button, and supports decimal numbers.



 Key Features:
 **Basic Arithmetic Operations**: Addition, subtraction, multiplication, and division.
 **Backspace Functionality**: Allows users to remove the last entered digit or operator.
 **Decimal Support**: Users can enter decimal numbers for more precise calculations.
 **Clear Functionality**: Clears both the current input and the result when pressed.



 Project Structure

 1. **MainActivity**
 The main activity that hosts the calculator UI.
 **UI Elements**: 
   `TextView` for displaying the working input (`workingsTV`) and the result (`resultsTV`).
   Buttons for numbers, operators, and actions (clear, backspace, equal).

 2. **Methods**
 **numberAction(view: View)**: Handles number and decimal input.
 **operationAction(view: View)**: Handles operator input (addition, subtraction, multiplication, division).
 **allclearAction(view: View)**: Clears all text from the input and result displays.
 **backspaceAction(view: View)**: Removes the last entered character.
 **equalAction(view: View)**: Calculates the result of the current input expression.
 **calculateResults()**: Handles the full expression evaluation.
 **addSubtractCalculate()**: Handles addition and subtraction operations.
 **timesDivisionCalculate()**: Handles multiplication and division operations.
 **calctimesDiv()**: Helper function for calculating multiplication and division.
 **digitsOperators()**: Parses the input into a list of digits and operators.



 Dependencies

 **Android SDK**: Standard Android SDK for UI and functionality.
 **Kotlin**: Used for app development and logic implementation.



 Setup

To set up the project locally, follow these steps:

1. Clone the repository:
   ```bash
   git clone https://github.com/<yourusername>/calculatorapp.git
   cd calculatorapp
   ```

2. Open the project in Android Studio.

3. Run the application on an Android device or emulator.



 Screenshots

**Calculator UI**  
![WhatsApp Image 2025-04-05 at 3 25 32 PM](https://github.com/user-attachments/assets/4d0d39da-d288-4564-8b02-0df57670930c)



 Author

**MARIND**



