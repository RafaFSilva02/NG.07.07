public class BankAccountException extends Exception {
    public BankAccountException(String message) {
        super(message);
    }

    public static class InsufficientFundsException extends BankAccountException {
        public InsufficientFundsException(String message) {
            super(message);
        }
    }

    public static class InvalidAmountException extends BankAccountException {
        public InvalidAmountException(String message) {
            super(message);
        }
    }

    public static class InvalidAccountException extends BankAccountException {
        public InvalidAccountException(String message) {
            super(message);
        }
    }

    public static class InvalidHolderException extends BankAccountException {
        public InvalidHolderException(String message) {
            super(message);
        }
    }

    public static class InvalidIdException extends BankAccountException {
        public InvalidIdException(String message) {
            super(message);
        }
    }
    
}