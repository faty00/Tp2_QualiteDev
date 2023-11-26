import fr.einfolearning.tp2.metiers.EmacsKillRing;
import fr.einfolearning.tp2.metiers.exceptions.EmacsKillRingOverflowException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class EmacsKillRingTest {

    @Test
    public void test_AddMethod_WithEmacsKillRingOverflowExceptionThrown()throws Exception, EmacsKillRingOverflowException {
        // Arrange
        EmacsKillRing emacsKillRing = new EmacsKillRing();
        int MAX = 20;
        // Act
        for(int i = 0; i < MAX ; i++){
            Assertions.assertDoesNotThrow(() -> emacsKillRing.add(""));
        }
        // Assert
        EmacsKillRingOverflowException exception = Assertions.assertThrows(EmacsKillRingOverflowException.class, () -> emacsKillRing.add(""), "l'exception EmacsKillRingOverflowException n'a pas été levée");
        assertEquals("EmacsKillRing overflow !", exception.getMessage());
    }

    @Test
    public void testAddMethod_WithEmacsKillRingOverflowExceptionThrown()throws Exception, EmacsKillRingOverflowException {
        // Arrange
        EmacsKillRing emacsKillRing = new EmacsKillRing();
        int MAX = EmacsKillRing.MAX;
        // Act
        for(int i = 0; i < MAX ; i++){
            Assertions.assertDoesNotThrow(() -> emacsKillRing.add(""));
        }
        // Assert
        EmacsKillRingOverflowException exception = Assertions.assertThrows(EmacsKillRingOverflowException.class, () -> emacsKillRing.add(""), "l'exception EmacsKillRingOverflowException n'a pas été levée");
        assertEquals("EmacsKillRing overflow !", exception.getMessage());
    }

    @Test
    public void must_display_false_if_the_list_contains_one_or_more_elements() throws EmacsKillRingOverflowException {
        // Arrange
        EmacsKillRing emacsKillRing = new EmacsKillRing();
        // Act
        emacsKillRing.add("toto");
        Boolean isEmpty= emacsKillRing.isEmpty();

        // Assert
        assertThat(isEmpty, is(false));

    }
    @Test
    public void should_display_true_if_the_list_isEmpty() throws EmacsKillRingOverflowException {
        // Arrange
        EmacsKillRing emacsKillRing = new EmacsKillRing();
        // Act
        Boolean isEmpty= emacsKillRing.isEmpty();

        // Assert
        assertThat(isEmpty, is(true));
    }

    @Test
    public void testCurrentEltMethod() throws EmacsKillRingOverflowException {
        // Arrange
        EmacsKillRing emacsKillRing = new EmacsKillRing();
        // Act
        emacsKillRing.add("toto");
        emacsKillRing.add("tata");
        String CurrentElt= emacsKillRing.currentElt();
        // Assert
        assertThat(CurrentElt, is("tata"));
    }
    @Test
    public void show_the_Scenario_different_method_Add_RotateFwd_Current_Element() throws EmacsKillRingOverflowException {
        // Arrange
        EmacsKillRing emacsKillRing = new EmacsKillRing();
        // Act
        emacsKillRing.add("toto");
        Assertions.assertDoesNotThrow(() -> emacsKillRing.rotateFwd());
        String CurrentElt1= emacsKillRing.currentElt();
        assertThat(CurrentElt1, is("toto"));

        emacsKillRing.add("tata");
        Assertions.assertDoesNotThrow(() -> emacsKillRing.rotateFwd());
        String CurrentElt2= emacsKillRing.currentElt();
        assertThat(CurrentElt2, is("toto"));

    }
    @Test
    public void should_display_the_set_of_items_stored_in_the_list() throws EmacsKillRingOverflowException {
        // Arrange
        EmacsKillRing emacsKillRing = new EmacsKillRing();
        // Act
        emacsKillRing.add("tata");
        emacsKillRing.add("toto");
        String string =emacsKillRing.toString();
        // Assert
        assertThat(string, is("[toto, tata]"));
    }
}