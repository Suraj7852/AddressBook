public class AddressBookException extends Throwable{
        enum ExceptionType {
            IO_EXCEPTION,NO_SUCH_FILE,ARRAY_INDEX_OUT_OF_BOUND
        }
        ExceptionType type;

        public AddressBookException(ExceptionType type, String message) {
            super(message);
            this.type=type;
        }

        public AddressBookException(ExceptionType type, Throwable cause) {
            super(cause);
            this.type=type;
        }

        public AddressBookException(ExceptionType type, String message, Throwable cause) {
            super(message,cause);
            this.type=type;
        }
}
