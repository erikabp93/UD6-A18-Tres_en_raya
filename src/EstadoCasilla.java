public enum EstadoCasilla {

    FICHA_O {
        public String toString() {
            return "\u2B55";
        }
    },
    FICHA_X {
        public String toString() {
            return "\u274C";
        }
    },
    VACIO {
        public String toString() {
            return "\uD83D\uDFEA";
        }
    }
}
