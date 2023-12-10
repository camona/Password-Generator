import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GeneratorTest {
    private final Password password = new Password("Secret");
    private final Alphabet onlyUppercase = new Alphabet(true, false, false, false);
    private final Alphabet noUppercase = new Alphabet(false, true, true, true);
    private final Generator generatorUppercase = new Generator(true, false, false, false);
    private final Generator generatorLowerCase = new Generator(false, true, false, false);

    @Test
    public void test1() {
        assertEquals("Secret", password.toString());
    }

    @Test
    public void test2() {
        assertEquals(onlyUppercase.getAlphabet(), Alphabet.UPPERCASE_LETTERS);
    }

    @Test
    public void test3() {
        assertEquals(noUppercase.getAlphabet(), Alphabet.LOWERCASE_LETTERS + Alphabet.NUMBERS + Alphabet.SYMBOLS);
    }

    @Test
    public void test4() {
        assertEquals(generatorUppercase.alphabet.getAlphabet(), Alphabet.UPPERCASE_LETTERS);
    }

    @Test
    public void test5() {
        assertEquals(generatorUppercase.alphabet.getAlphabet().length(), 26);
    }

    @Test
    public void test6() {
        assertEquals(generatorLowerCase.alphabet.getAlphabet().length(), 26);
    }
}