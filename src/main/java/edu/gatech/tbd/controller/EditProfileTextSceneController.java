package edu.gatech.tbd.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import edu.gatech.tbd.model.User;
import edu.gatech.tbd.model.UserException;
import edu.gatech.tbd.model.UserManager;
import edu.gatech.tbd.model.UserProperty;

/**
 * Controller for the Edit Profile Text Scene.
 */
public class EditProfileTextSceneController extends SceneController {

	@FXML
	private TextField nameField;

	@FXML
	private Label propertyLabel;

	@FXML
	private Label promptLabel;

	@FXML
	private Label errorLabel;

	@FXML
	Button submitButton;

    @FXML
	Button goBackButton;

	private UserProperty p;
	
	/**
	 * Sets the user's information from the given property.
	 * 
	 * @param u User to be edited
	 * @param p Property of User u to be edited
	 */
	public void setInfo(User u, UserProperty p) {
		this.p = p;
		switch (p) {
		case Name:
			nameField.setText(u.getName());
			propertyLabel.setText("Name:");
			promptLabel.setText("Please enter your new Name.");
			break;
		case Address:
			nameField.setText(u.getAddress());
			propertyLabel.setText("Address:");
			promptLabel.setText("Please enter your new Address.");
			break;
		case Email:
			nameField.setText(u.getEmail());
			propertyLabel.setText("Email:");
			promptLabel.setText("Please enter your new Email.");
			break;
		case Password:
			nameField.setText("***"); // u.getPassword()); this was printing a long string of random characters
			propertyLabel.setText("Password:");
			promptLabel.setText("Please enter your new Password.");
			break;
		case Username:
			nameField.setText(u.getUsername());
			propertyLabel.setText("Username:");
			promptLabel.setText("Please enter your new Username.");
			break;
		default:
			break;
		}
	}
	
	/**
	 * Handler for the Submit button.
	 */
	@FXML
	protected void onSubmitButtonPressed() {
		try {
			User u = UserManager.getLoggedInUser();
			String name = u.getName();
			String username = u.getUsername();
			String password = u.getPassword();
			String email = u.getEmail();
			String address = u.getAddress();
			switch (p) {
			case Name:
				name = nameField.getText();
				break;
			case Address:
				address = nameField.getText();
				break;
			case Email:
				email = nameField.getText();
				break;
			case Password:
				password = nameField.getText();
				break;
			case Username:
				username = nameField.getText();
				break;
			default:
				break;
			}
			UserManager.updateUserInformation(UserManager.getLoggedInUser(), name, username, password, u.getType(),
					email, address);
			mainApp.closePopup();
			mainApp.doPopupWindow("EditProfileScene");
		} catch (UserException e) {
			errorLabel.setText(e.getMessage());
		}
	}

	/**
	 * Handler for the Go Back button.
	 */
	@FXML
	protected void onGoBackButtonPressed() {
		mainApp.closePopup();
		mainApp.doPopupWindow("EditProfileScene");
	}
}
