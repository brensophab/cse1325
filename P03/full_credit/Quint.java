import java.io.*;
import java.util.*;
import java.text.Normalizer;

public class Quint{
	public static void main(String[] args){
		Puzzle puzzle = new Puzzle();
		puzzle.Puzzle();
	}
		
	
}
class WordList {
    public static String getWord() {
        return words[(int) (words.length * Math.random())];
    }
    private final static String[] words = new String[]{     "CIGAR",  "REBUT",  "SISSY",  "HUMPH",  "AWAKE",  "BLUSH",  "FOCAL",  "EVADE",  "NAVAL",  "SERVE",  "HEATH",  "DWARF",  "MODEL",  "KARMA",  "STINK",  "GRADE",  "QUIET",  "BENCH",  "ABATE",  "FEIGN",  "MAJOR",  "DEATH",  "FRESH",  "CRUST",  "STOOL",  "COLON",  "ABASE",  "MARRY",  "REACT",  "BATTY",  "PRIDE",  "FLOSS",  "HELIX",  "CROAK",  "STAFF",  "PAPER",  "UNFED",  "WHELP",  "TRAWL",  "OUTDO",  "ADOBE",  "CRAZY",  "SOWER",  "REPAY",  "DIGIT",  "CRATE",  "CLUCK",  "SPIKE",  "MIMIC",  "POUND",  "MAXIM",  "LINEN",  "UNMET",  "FLESH",  "BOOBY",  "FORTH",  "FIRST",  "STAND",  "BELLY",  "IVORY",  "SEEDY",  "PRINT",  "YEARN",  "DRAIN",  "BRIBE",  "STOUT",  "PANEL",  "CRASS",  "FLUME",  "OFFAL",  "AGREE",  "ERROR",  "SWIRL",  "ARGUE",  "BLEED",  "DELTA",  "FLICK",  "TOTEM",  "WOOER",  "FRONT",  "SHRUB",  "PARRY",  "BIOME",  "LAPEL",  "START",  "GREET",  "GONER",  "GOLEM",  "LUSTY",  "LOOPY",  "ROUND",  "AUDIT",  "LYING",  "GAMMA",  "LABOR",  "ISLET",  "CIVIC",  "FORGE",  "CORNY",  "MOULT",  "BASIC",  "SALAD",  "AGATE",  "SPICY",  "SPRAY",  "ESSAY",  "FJORD",  "SPEND",  "KEBAB",  "GUILD",  "ABACK",  "MOTOR",  "ALONE",  "HATCH",  "HYPER",  "THUMB",  "DOWRY",  "OUGHT",  "BELCH",  "DUTCH",  "PILOT",  "TWEED",  "COMET",  "JAUNT",  "ENEMA",  "STEED",  "ABYSS",  "GROWL",  "FLING",  "DOZEN",  "BOOZY",  "ERODE",  "WORLD",  "GOUGE",  "CLICK",  "BRIAR",  "GREAT",  "ALTAR",  "PULPY",  "BLURT",  "COAST",  "DUCHY",  "GROIN",  "FIXER",  "GROUP",  "ROGUE",  "BADLY",  "SMART",  "PITHY",  "GAUDY",  "CHILL",  "HERON",  "VODKA",  "FINER",  "SURER",  "RADIO",  "ROUGE",  "PERCH",  "RETCH",  "WROTE",  "CLOCK",  "TILDE",  "STORE",  "PROVE",  "BRING",  "SOLVE",  "CHEAT",  "GRIME",  "EXULT",  "USHER",  "EPOCH",  "TRIAD",  "BREAK",  "RHINO",  "VIRAL",  "CONIC",  "MASSE",  "SONIC",  "VITAL",  "TRACE",  "USING",  "PEACH",  "CHAMP",  "BATON",  "BRAKE",  "PLUCK",  "CRAZE",  "GRIPE",  "WEARY",  "PICKY",  "ACUTE",  "FERRY",  "ASIDE",  "TAPIR",  "TROLL",  "UNIFY",  "REBUS",  "BOOST",  "TRUSS",  "SIEGE",  "TIGER",  "BANAL",  "SLUMP",  "CRANK",  "GORGE",  "QUERY",  "DRINK",  "FAVOR",  "ABBEY",  "TANGY",  "PANIC",  "SOLAR",  "SHIRE",  "PROXY",  "POINT",  "ROBOT",  "PRICK",  "WINCE",  "CRIMP",  "KNOLL",  "SUGAR",  "WHACK",  "MOUNT",  "PERKY",  "COULD",  "WRUNG",  "LIGHT",  "THOSE",  "MOIST",  "SHARD",  "PLEAT",  "ALOFT",  "SKILL",  "ELDER",  "FRAME",  "HUMOR",  "PAUSE",  "ULCER",  "ULTRA",  "ROBIN",  "CYNIC",  "AGORA",  "AROMA",  "CAULK",  "SHAKE",  "PUPAL",  "DODGE",  "SWILL",  "TACIT",  "OTHER",  "THORN",  "TROVE",  "BLOKE",  "VIVID",  "SPILL",  "CHANT",  "CHOKE",  "RUPEE",  "NASTY",  "MOURN",  "AHEAD",  "BRINE",  "CLOTH",  "HOARD",  "SWEET",  "MONTH",  "LAPSE",  "WATCH",  "TODAY",  "FOCUS",  "SMELT",  "TEASE",  "CATER",  "MOVIE",  "LYNCH",  "SAUTE",  "ALLOW",  "RENEW",  "THEIR",  "SLOSH",  "PURGE",  "CHEST",  "DEPOT",  "EPOXY",  "NYMPH",  "FOUND",  "SHALL",  "HARRY",  "STOVE",  "LOWLY",  "SNOUT",  "TROPE",  "FEWER",  "SHAWL",  "NATAL",  "FIBRE",  "COMMA",  "FORAY",  "SCARE",  "STAIR",  "BLACK",  "SQUAD",  "ROYAL",  "CHUNK",  "MINCE",  "SLAVE",  "SHAME",  "CHEEK",  "AMPLE",  "FLAIR",  "FOYER",  "CARGO",  "OXIDE",  "PLANT",  "OLIVE",  "INERT",  "ASKEW",  "HEIST",  "SHOWN",  "ZESTY",  "HASTY",  "TRASH",  "FELLA",  "LARVA",  "FORGO",  "STORY",  "HAIRY",  "TRAIN",  "HOMER",  "BADGE",  "MIDST",  "CANNY",  "FETUS",  "BUTCH",  "FARCE",  "SLUNG",  "TIPSY",  "METAL",  "YIELD",  "DELVE",  "BEING",  "SCOUR",  "GLASS",  "GAMER",  "SCRAP",  "MONEY",  "HINGE",  "ALBUM",  "VOUCH",  "ASSET",  "TIARA",  "CREPT",  "BAYOU",  "ATOLL",  "MANOR",  "CREAK",  "SHOWY",  "PHASE",  "FROTH",  "DEPTH",  "GLOOM",  "FLOOD",  "TRAIT",  "GIRTH",  "PIETY",  "PAYER",  "GOOSE",  "FLOAT",  "DONOR",  "ATONE",  "PRIMO",  "APRON",  "BLOWN",  "CACAO",  "LOSER",  "INPUT",  "GLOAT",  "AWFUL",  "BRINK",  "SMITE",  "BEADY",  "RUSTY",  "RETRO",  "DROLL",  "GAWKY",  "HUTCH",  "PINTO",  "GAILY",  "EGRET",  "LILAC",  "SEVER",  "FIELD",  "FLUFF",  "HYDRO",  "FLACK",  "AGAPE",  "WENCH",  "VOICE",  "STEAD",  "STALK",  "BERTH",  "MADAM",  "NIGHT",  "BLAND",  "LIVER",  "WEDGE",  "AUGUR",  "ROOMY",  "WACKY",  "FLOCK",  "ANGRY",  "BOBBY",  "TRITE",  "APHID",  "TRYST",  "MIDGE",  "POWER",  "ELOPE",  "CINCH",  "MOTTO",  "STOMP",  "UPSET",  "BLUFF",  "CRAMP",  "QUART",  "COYLY",  "YOUTH",  "RHYME",  "BUGGY",  "ALIEN",  "SMEAR",  "UNFIT",  "PATTY",  "CLING",  "GLEAN",  "LABEL",  "HUNKY",  "KHAKI",  "POKER",  "GRUEL",  "TWICE"};
}
	
class Puzzle{
	//solution = player answer
	//solved=real answer
	private Word solution;
	private boolean solved;
 	public  boolean isSolved(){ // if true, print out congrats and counter for guesses
		return(solution.equals(guess));
 	}	
	 public String compareGuess(String guess){
		//For actual and check, letters will be replaced with spaces when found
		Word actual = new Word(solution.toString());//puzzle solution
		Word check  =  new Word(guess); 				//Guess at solution
		Word result = new Word ("...."); 			//Result to be returned
		
		//Check for correct letter in correct position
		for(int i=0; i<5; ++i) {
			if(check.charAt(i)==actual.charAt(i)){
					result.setCharAt(Character.toUpperCase(solution.charAt(i)), i);
					check.setCharAt(' ', i);
					actual.setCharAt(' ', i);
					continue;
				}
			}
			
		}	
	
	public Puzzle(){
		System.out.println("=========\nQ U I N T\n =========\n");
		System.out.println("guess a 5 letter word");
		Scanner solved = new Scanner(System.in);
		String[] guess = solved.nextLine(); //At this point you convert the string into a character array, with each letter in the word being an index, and compare this to the
		// value of the char of the word selected from WordList, but i was quite unsure of how to implement.
	}
}

class Word{
	private char letters= new char[5];
	public Word(String word){ //Im assuming this gets a word from the wordlist class.
		WordList.getWord();
		getWord=new char[getWord.length()];
		for (int i = 0; i < str.length(); i++){
            getWord[i] = getWord.charAt(i);
		}
	 public char charAt(int position){ //
	 // Creating array of string length
	 char[] guess = new char[str.length()];
	 char[] solution = new char[str.length()];
  
	 // Copy character by character into array
	 for (int i = 0; i < str.length(); i++) {
		 guess[i] = str.charAt(i);
	 }
	}
	public int setCharAt(char c, int position){
	//iterate through player character array and compare to answer array. if .equals, place the character there, else, place dot.
	}
	public String toString(){ // not quite sure what to put here
		return 0;
	}
	
}//This is kinda hard :(
}