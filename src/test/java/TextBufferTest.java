import fr.einfolearning.tp2.metiers.TextBuffer;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TextBufferTest {
    @Test
    public void should_get_correct_str_buffer_when_instantiateTextBuffer()throws Exception{
        // Arrange
        TextBuffer textBuffer = new TextBuffer("toto");
        String bufferText = "toto";
        // Act
        String textBufferString = textBuffer.toString();
        // Assert
        assertThat(bufferText, is(textBufferString));
    }
    @Test
    public void should_insert_text_at_a_specific_position()throws Exception{
        // Arrange
        TextBuffer textBuffer = new TextBuffer("toto");
        // Act
        textBuffer.ins("koko",1);
        String nom=textBuffer.toString();
        // Assert
        assertThat(nom, is("tkokooto"));
    }
    @Test
    public void it_should_not_insert_text_at_a_position_lower_than_zero()throws Exception{
        // Arrange
        TextBuffer textBuffer = new TextBuffer("toto");
        // Act
        textBuffer.ins("koko",-1);
        String nom=textBuffer.toString();
        // Assert
        assertThat(nom, is("toto"));
    }
    @Test
    public void it_should_not_insert_text_at_a_position_greater_than_the_size_of_instantiateTextBuffer() throws Exception{
        // Arrange
        TextBuffer textBuffer = new TextBuffer("toto");
        // Act
        textBuffer.ins("koko",textBuffer.maxP()+1);
        String nom=textBuffer.toString();
        // Assert
        assertThat(nom, is("toto"));
    }

    @Test
    public void should_remove_text_greater_than_or_equal_to_zero_and_less_than_the_size_of_instantiateTextBuffer_for_deletion()throws Exception{
        // Arrange
        TextBuffer textBuffer = new TextBuffer("toto");
        // Act
        textBuffer.del(2,4);
        String nom=textBuffer.toString();
        // Assert
        assertThat(nom, is("to"));
    }
    @Test
    public void should_take_the_max_index_of_instantiateTextBuffer_if_to_greater_than_size_of_instantiateTextBuffer_for_deletion()throws Exception{
        // Arrange
        TextBuffer textBuffer = new TextBuffer("toto");
        // Act
        textBuffer.del(1,5);
        String nom=textBuffer.toString();
        // Assert
        assertThat(nom, is("t"));
    }

    @Test
    public void should_take_index_zero_if_from_less_than_zero_for_deletion()throws Exception{
        // Arrange
        TextBuffer textBuffer = new TextBuffer("toto");
        // Act
        textBuffer.del(-1,2);
        String nom=textBuffer.toString();
        // Assert
        assertThat(nom, is("to"));
    }
    @Test
    public void should_take_index_zero_if_to_less_than_zero_for_deletion()throws Exception{
        // Arrange
        TextBuffer textBuffer = new TextBuffer("toto");
        // Act
        textBuffer.del(0,-1);
        String nom=textBuffer.toString();
        // Assert
        assertThat(nom, is("toto"));
    }
    @Test
    public void should_take_the_maximum_if_from_and_to_are_greater_than_the_size_of_instantiateTextBuffer_for_deletion()throws Exception{
        // Arrange
        TextBuffer textBuffer = new TextBuffer("toto");
        // Act
        textBuffer.del(5,5);
        String nom=textBuffer.toString();
        // Assert
        assertThat(nom, is("toto"));
    }

    @Test
    public void should_extract_a_substring_between_fromm_and_to()throws Exception{
        // Arrange
        TextBuffer textBuffer = new TextBuffer("toto");
        // Act
        String nom= textBuffer.substr(0,3);
        // Assert
        assertThat(nom, is("tot"));
    }
    @Test
    public void should_extract_a_substring_between_from_and_to_and_it_will_take_from_equal_zero_if_it_is_less_than_zero()throws Exception{
        // Arrange
        TextBuffer textBuffer = new TextBuffer("toto");
        // Act
        String nom= textBuffer.substr(-1,2);
        // Assert
        assertThat(nom, is("to"));
    }
    @Test
    public void should_extract_a_substring_between_from_and_to_and_it_will_take_to_equal_max_if_it_is_greater_than_the_size_of_instantiateTextBuffer()throws Exception{
        // Arrange
        TextBuffer textBuffer = new TextBuffer("toto");
        // Act
        String nom=textBuffer.substr(0,-1);
        // Assert
        assertThat(nom, is(""));
    }
    @Test
    public void should_extract_a_substring_between_from_and_to_and_it_will_take_form_equal_to_zero_if_it_is_greater_than_the_size_of_instantiateTextBuffer()throws Exception{
        // Arrange
        TextBuffer textBuffer = new TextBuffer("toto");
        // Act
        String nom=textBuffer.substr(textBuffer.maxP()+1,4);
        // Assert
        assertThat(nom, is(""));
    }
    @Test
    public void should_extract_a_substring_between_from_and_to_and_it_will_take_to_equal_to_max_if_it_is_greater_than_the_size_of_instantiateTextBuffer()throws Exception{
        // Arrange
        TextBuffer textBuffer = new TextBuffer("toto");
        // Act
        String nom=textBuffer.substr(0,textBuffer.maxP()+1);
        // Assert
        assertThat(nom, is("toto"));
    }
}
