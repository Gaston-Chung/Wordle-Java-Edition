import java.util.List;

public class Word
{
    // Instance Variables
    private String wordText;

    // Constructor
    public Word(String someText)
    {
        this.wordText = someText;
    }

    public static Word currentWord;

    public static String getCurrentWordString()
    {
        return currentWord.wordText;
    }

    // Define 100 Word objects
    public static Word GHOUL = new Word("GHOUL");
    public static Word SPEED = new Word("SPEED");
    public static Word CLIMB = new Word("CLIMB");
    public static Word DREAM = new Word("DREAM");
    public static Word FLASH = new Word("FLASH");
    public static Word SWORD = new Word("SWORD");
    public static Word KNIFE = new Word("KNIFE");
    public static Word BRICK = new Word("BRICK");
    public static Word CRISP = new Word("CRISP");
    public static Word BLOOM = new Word("BLOOM");
    public static Word STORM = new Word("STORM");
    public static Word QUICK = new Word("QUICK");
    public static Word GRAPE = new Word("GRAPE");
    public static Word PRISM = new Word("PRISM");
    public static Word GHOST = new Word("GHOST");
    public static Word BLAST = new Word("BLAST");
    public static Word CANDY = new Word("CANDY");
    public static Word NIGHT = new Word("NIGHT");
    public static Word WHALE = new Word("WHALE");
    public static Word CHARM = new Word("CHARM");
    public static Word FLAME = new Word("FLAME");
    public static Word BLADE = new Word("BLADE");
    public static Word WALTZ = new Word("WALTZ");
    public static Word TWIST = new Word("TWIST");
    public static Word GLOVE = new Word("GLOVE");
    public static Word LATCH = new Word("LATCH");
    public static Word PLANT = new Word("PLANT");
    public static Word SCARY = new Word("SCARY");
    public static Word CHASE = new Word("CHASE");
    public static Word TREND = new Word("TREND");
    public static Word FRUIT = new Word("FRUIT");
    public static Word LEVEL = new Word("LEVEL");
    public static Word SNEAK = new Word("SNEAK");
    public static Word PATCH = new Word("PATCH");
    public static Word ZEBRA = new Word("ZEBRA");
    public static Word MIGHT = new Word("MIGHT");
    public static Word TRICK = new Word("TRICK");
    public static Word WOUND = new Word("WOUND");
    public static Word SPIKE = new Word("SPIKE");
    public static Word TROLL = new Word("TROLL");
    public static Word PIZZA = new Word("PIZZA");
    public static Word BERRY = new Word("BERRY");
    public static Word TRAIN = new Word("TRAIN");
    public static Word SCALE = new Word("SCALE");
    public static Word BLANK = new Word("BLANK");
    public static Word CRATE = new Word("CRATE");
    public static Word BROOM = new Word("BROOM");
    public static Word GAZER = new Word("GAZER");
    public static Word SCARE = new Word("SCARE");
    public static Word ALIEN = new Word("ALIEN");
    public static Word BRUSH = new Word("BRUSH");
    public static Word DANCE = new Word("DANCE");
    public static Word ELBOW = new Word("ELBOW");
    public static Word FROST = new Word("FROST");
    public static Word GIANT = new Word("GIANT");
    public static Word HELLO = new Word("HELLO");
    public static Word IGLOO = new Word("IGLOO");
    public static Word JELLY = new Word("JELLY");
    public static Word KOALA = new Word("KOALA");
    public static Word LUNAR = new Word("LUNAR");
    public static Word MOVER = new Word("MOVER");
    public static Word NOBLE = new Word("NOBLE");
    public static Word OPERA = new Word("OPERA");
    public static Word PIANO = new Word("PIANO");
    public static Word QUEST = new Word("QUEST");
    public static Word RIDGE = new Word("RIDGE");
    public static Word SLOTH = new Word("SLOTH");
    public static Word THIEF = new Word("THIEF");
    public static Word UNCLE = new Word("UNCLE");
    public static Word VENOM = new Word("VENOM");
    public static Word WAGON = new Word("WAGON");
    public static Word YEAST = new Word("YEAST");
    public static Word ZONED = new Word("ZONED");
    public static Word ARROW = new Word("ARROW");
    public static Word BLINK = new Word("BLINK");
    public static Word CHINA = new Word("CHINA");
    public static Word DUSKY = new Word("DUSKY");
    public static Word EAGLE = new Word("EAGLE");
    public static Word FABLE = new Word("FABLE");
    public static Word GLASS = new Word("GLASS");
    public static Word HORSE = new Word("HORSE");
    public static Word INFER = new Word("INFER");
    public static Word JUICE = new Word("JUICE");
    public static Word KNEEL = new Word("KNEEL");
    public static Word LOOSE = new Word("LOOSE");
    public static Word MARCH = new Word("MARCH");
    public static Word NOISE = new Word("NOISE");
    public static Word ODDLY = new Word("ODDLY");
    public static Word PROUD = new Word("PROUD");
    public static Word QUACK = new Word("QUACK");
    public static Word RAZOR = new Word("RAZOR");
    public static Word SHINE = new Word("SHINE");
    public static Word TIGHT = new Word("TIGHT");
    public static Word URBAN = new Word("URBAN");
    public static Word VIVID = new Word("VIVID");
    public static Word WATER = new Word("WATER");
    public static Word YOUTH = new Word("YOUTH");

    // Word List
    public static final List<Word> masterList = List.of(
        GHOUL, SPEED, CLIMB, DREAM, FLASH, SWORD, KNIFE, BRICK, CRISP, BLOOM,
        STORM, QUICK, GRAPE, PRISM, GHOST, BLAST, CANDY, NIGHT, WHALE, CHARM,
        FLAME, BLADE, WALTZ, TWIST, GLOVE, LATCH, PLANT, SCARY, CHASE, TREND,
        FRUIT, LEVEL, SNEAK, PATCH, ZEBRA, MIGHT, TRICK, WOUND, SPIKE, TROLL,
        PIZZA, BERRY, TRAIN, SCALE, BLANK, CRATE, BROOM, GAZER, SCARE,
        ALIEN, BRUSH, DANCE, ELBOW, FROST, GIANT, HELLO, IGLOO, JELLY, KOALA,
        LUNAR, MOVER, NOBLE, OPERA, PIANO, QUEST, RIDGE, SLOTH, THIEF, UNCLE,
        VENOM, WAGON, YEAST, ZONED, ARROW, BLINK, CHINA, DUSKY, EAGLE, FABLE,
        GLASS, HORSE, INFER, JUICE, KNEEL, LOOSE, MARCH, NOISE, ODDLY, PROUD,
        QUACK, RAZOR, SHINE, TIGHT, URBAN, VIVID, WATER, YOUTH
    );

    public static final List<String> masterListString = List.of(
    "GHOUL", "SPEED", "CLIMB", "DREAM", "FLASH", "SWORD", "KNIFE", "BRICK", "CRISP", "BLOOM",
    "STORM", "QUICK", "GRAPE", "PRISM", "GHOST", "BLAST", "CANDY", "NIGHT", "WHALE", "CHARM",
    "FLAME", "BLADE", "WALTZ", "TWIST", "GLOVE", "LATCH", "PLANT", "SCARY", "CHASE", "TREND",
    "FRUIT", "LEVEL", "SNEAK", "PATCH", "ZEBRA", "MIGHT", "TRICK", "WOUND", "SPIKE", "TROLL",
    "PIZZA", "BERRY", "TRAIN", "SCALE", "BLANK", "CRATE", "BROOM", "GAZER", "SCARE",
    "ALIEN", "BRUSH", "DANCE", "ELBOW", "FROST", "GIANT", "HELLO", "IGLOO", "JELLY", "KOALA",
    "LUNAR", "MOVER", "NOBLE", "OPERA", "PIANO", "QUEST", "RIDGE", "SLOTH", "THIEF", "UNCLE",
    "VENOM", "WAGON", "YEAST", "ZONED", "ARROW", "BLINK", "CHINA", "DUSKY", "EAGLE", "FABLE",
    "GLASS", "HORSE", "INFER", "JUICE", "KNEEL", "LOOSE", "MARCH", "NOISE", "ODDLY", "PROUD",
    "QUACK", "RAZOR", "SHINE", "TIGHT", "URBAN", "VIVID", "WATER", "YOUTH"
);


    // Generate a random word
    public static Word generateRandomWord()
    {
        int index = (int) (Math.random() * masterList.size());
        currentWord = masterList.get(index);
        return currentWord;
    }
}
