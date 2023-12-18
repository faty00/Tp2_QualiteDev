
import fr.einfolearning.tp2.metiers.EmacsKillRing;
import fr.einfolearning.tp2.metiers.TextBuffer;
import fr.einfolearning.tp2.metiers.TextEditor;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.stubbing.OngoingStubbing;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class TextEditorTest {

   @Test
    public void should_throw_IllegalAccessException_when_yankMode_equal_false() {
        TextEditor textEditor = new TextEditor("koko");
        IllegalAccessException exception = assertThrows(IllegalAccessException.class, () -> textEditor.yankPop(), "Yankpop without yank not allowed");
        assertEquals("Yankpop without yank not allowed", exception.getMessage());
    }

    @Test
    public void test_yank_pop() throws IllegalAccessException, NoSuchFieldException {
        EmacsKillRing emacsKillRing = mock(EmacsKillRing.class);
        TextEditor textEditor = new TextEditor("koko");

        // Set yankMode to true
        Field yankModeField = TextEditor.class.getDeclaredField("yankMode");
        yankModeField.setAccessible(true);
        yankModeField.set(textEditor, true);

        when(emacsKillRing.isEmpty()).thenReturn(true); // Set kill ring as empty

        IllegalAccessException exception = assertThrows(IllegalAccessException.class, () -> textEditor.yankPop(), "Cannot yank an empty kill ring");

        assertEquals("Cannot yank an empty kill ring", exception.getMessage());
    }

    @Test
    public void test_yank_pop3() throws IllegalAccessException {
        TextEditor textEditor = new TextEditor("koko");
        //Mockup
        EmacsKillRing emacsKillRing = mock(EmacsKillRing.class);
        when(emacsKillRing.isEmpty()).thenReturn(false);
        TextBuffer textBuffer= mock(TextBuffer.class);

        //textEditor.yank();
        doNothing().when(emacsKillRing).rotateFwd();
        when(emacsKillRing.currentElt()).thenReturn("");
        doNothing().when(textBuffer).del(anyInt(),anyInt());
        doNothing().when(textBuffer).ins(anyString(),anyInt());
        emacsKillRing.currentElt();
        textBuffer.ins(anyString(),anyInt());
        verify(emacsKillRing, times(1)).currentElt();
        verify(textBuffer, times(1)).ins(anyString(),anyInt());
    }

}
