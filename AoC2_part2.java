import java.io.*;

public class AoC2_part2 {
    public void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /*
         * A, X: ROCK (1)
         * B, Y: PAPER (2)
         * C, Z: SCISSORS (3)
         * score 6 if win
         * score 3 if draw
         * 0 if lose
         */

        String line;
        long totalScore = 0;
        while((line = br.readLine()).compareTo("*") != 0) {
            String[] inputs = line.split(" ");
            getAppropriateShape(inputs);
            totalScore += getShpaeScore(inputs[1]);
            totalScore += getRoundResult(inputs);
        }
        br.close();
        bw.write(String.valueOf(totalScore));
        bw.newLine();
        bw.flush();
        bw.close();
    }

    private void getAppropriateShape(String[] inputs) {
        /*
        X: lose
        Y: draw
        Z: win
         */
        if (inputs[0].compareTo("A") == 0) {
            if (inputs[1].compareTo("X") == 0) {
                inputs[1] = "Z";
            }
            else if (inputs[1].compareTo("Y") == 0) {
                inputs[1] = "X";
            }
            else if (inputs[1].compareTo("Z") == 0) {
                inputs[1] = "Y";
            }
        }
        else if (inputs[0].compareTo("B") == 0) {
            if (inputs[1].compareTo("X") == 0) {
                inputs[1] = "X";
            }
            else if (inputs[1].compareTo("Y") == 0) {
                inputs[1] = "Y";
            }
            else if (inputs[1].compareTo("Z") == 0) {
                inputs[1] = "Z";
            }
        }
        else if (inputs[0].compareTo("C") == 0) {
            if (inputs[1].compareTo("X") == 0) {
                inputs[1] = "Y";
            }
            else if (inputs[1].compareTo("Y") == 0) {
                inputs[1] = "Z";
            }
            else if (inputs[1].compareTo("Z") == 0) {
                inputs[1] = "X";
            }
        }
    }
    private long getShpaeScore(String shape) {
        return switch (shape) {
            case "X" -> 1;
            case "Y" -> 2;
            case "Z" -> 3;
            default -> 0;
        };
    }
    private long getRoundResult(String[] inputs) {
        // oppenent : ROCK
        if (inputs[0].compareTo("A") == 0) {
            if (inputs[1].compareTo("X") == 0) {
                return 3;
            }
            if (inputs[1].compareTo("Y") == 0) {
                return 6;
            }
            return 0;
        }
        if (inputs[0].compareTo("B") == 0) {
            if (inputs[1].compareTo("X") == 0) {
                return 0;
            }
            if (inputs[1].compareTo("Y") == 0) {
                return 3;
            }
            return 6;
        }
        if (inputs[0].compareTo("C") == 0) {
            if (inputs[1].compareTo("X") == 0) {
                return 6;
            }
            if (inputs[1].compareTo("Y") == 0) {
                return 0;
            }
            return 3;
        }
        return 0;
    }
}
