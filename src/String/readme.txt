
// Reading chars from a file... file ends with newline

                System.out.println("lastchar = 10" + "  int = " + (int)lastChar);

                System.out.println("\n".equals(String.valueOf(lastChar)) + " \\n");
                System.out.println("\r".equals(String.valueOf(forLastChar)) + " \\r");
                String lastText = String.valueOf(forLastChar) + String.valueOf(lastChar);
//                if (lastText.equals(System.lineSeparator())) {
                    fWriter.write("\b");
