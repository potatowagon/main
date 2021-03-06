package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import seedu.address.model.task.DeadlineTask;

public class DeadlineTaskListCard extends UiPart<Pane> {

    private static final String FXML = "/view/DeadlineTaskListCard.fxml";

    @FXML
    private Label indexLabel;

    @FXML
    private Label nameLabel;

    @FXML
    private Label dueLabel;

    /**
     * @param deadlineTask The deadline task to display. Can be null to not display anything.
     */
    public DeadlineTaskListCard(DeadlineTask deadlineTask, int index) {
        super(FXML);
        if (deadlineTask != null) {
            indexLabel.setText(index + ". ");
            nameLabel.setText(deadlineTask.name.toString());
            dueLabel.setText(deadlineTask.getDue().toString());
        } else {
            getRoot().setVisible(false);
        }
    }

}
