
public class help_functions {
	/* ------------------------------------- Name Checker -------------------------------------------------------*/
		public static boolean isValidName(String name) {
			return isHasOneSpace(name) && isAllOfCharsValid(name);
		}
		private static boolean isHasOneSpace(String name) {
			int counter=0;
			for(int i =0 ; i<name.length();i++) {
				if(name.charAt(i)==' ') {
					counter++;
				}
			}
			return counter==1 || counter ==0;
		}
		private static boolean isAllOfCharsValid(String name) {
			boolean r = true;
			for(int i=0 ; i<name.length();i++){
				if(!isValidChar(name.charAt(i)) && !isNumber(name.charAt(i)) && name.charAt(i) !=' ') {
					r=false ;
					break;
				}
			}
			return r;
		}
		private static boolean isValidChar(char a) {
			a=Character.toUpperCase(a);
			return a>='A' && a<='Z';
		}
	/* ------------------------------------- End Of Name Checker -------------------------------------------------------*/
		
		/* ------------------------------------- Email Checker -------------------------------------------------------*/
		public static boolean isEmail(String Email) {
			boolean r = false;
			for(int i =0 ;i<Email.length();i++) {
				if(Email.charAt(i) == '@') {
					r=true;
					break;
				}
			}
			return r;
		}
	/* ------------------------------------- End Of Email Checker -------------------------------------------------------*/
	  /* ------------------------------------- Password Checker -------------------------------------------------------*/
		public static boolean isValidPass(String password) {
			boolean r = password.length()>=9 && isValidChars(password);
			return r;
		}
		private static boolean isValidChars(String password) {
			int numbersCounter=0;
			int charsCounter=0;
			for(int i =0 ; i< password.length(); i++) {
				if(isNumber(password.charAt(i))) {
					numbersCounter++;
				}else {
					charsCounter++;
				}
			}
			return (charsCounter>=7 && charsCounter<=9)&&(numbersCounter>=2 && numbersCounter<=4);
		}
		private static boolean isNumber(char a) {
			return a>='0' && a<='9';
		}

}
