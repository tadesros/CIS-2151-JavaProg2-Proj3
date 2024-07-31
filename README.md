# CIS-2151-JavaProg2-Proj3
Java FX

    public static void main(String[] args) {
        // TODO code application logic here
        String testString = "   Test    ";
        String testString2 = "Test2";
        
        
            String newString = testString.trim();
            
            newString = newString.toLowerCase();
           System.out.print(newString);
           System.out.print(newString);
    }

Certainly! Let’s dive into JavaFX and tackle this step by step. 😊

1. Creating a TextField in JavaFX:

A TextField in JavaFX is a control that allows users to input a single line of unformatted text12. You can use it to capture user input, such as names, search queries, or any other single-line text.
To create a TextField, you’ll typically do something like this:
Java

TextField textField = new TextField();
AI-generated code. Review and use carefully. More info on FAQ.
2. Writing Text from the TextField to a List:

If you want to take the text entered in a TextField and add it to a list (e.g., a ListView), you can follow these steps:
Create a ListView:
First, create a ListView where you want to display the entered text. For example:
Java

ListView<String> listView = new ListView<>();
AI-generated code. Review and use carefully. More info on FAQ.
Event Handling:
Next, set up an event handler for your TextField. You’ll typically listen for the “Enter” key press (or any other suitable event) to capture the text.
Here’s a simple example using an ActionEvent (when the user presses Enter):
Java

textField.setOnAction(event -> {
    String enteredText = textField.getText();
    listView.getItems().add(enteredText);
    textField.clear(); // Clear the TextField after adding to the list
});
AI-generated code. Review and use carefully. More info on FAQ.
Display the ListView:
Finally, make sure your ListView is part of your scene graph so that it’s visible to the user.
3. Numeric Validation (Optional):

If you want to enforce specific formats (e.g., numeric input), you can use a TextFormatter or a UnaryOperator3.
For numeric input, consider using a TextFormatter with a filter that allows only valid numeric characters.
Remember, JavaFX provides a lot of flexibility, so feel free to adapt this to your specific use case. If you have any more questions or need further assistance, feel free to ask! 🌟



https://www.youtube.com/watch?v=TDyIRhqdNqs














