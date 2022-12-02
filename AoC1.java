import java.io.*;

public class AoC1 {

    public static void main(String[] args) throws IOException {
        AoC1 Main = new AoC1();
        Main.io();
    }

    private void io() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line;
        long sum = 0;
        long maxSum = 0;
        long[] topThreeSum = new long[3];
        try {

            while ((line = br.readLine()) != null) {
                if (line.compareTo("*") == 0)
                    break;
                if (line.compareTo("") == 0) {
                    updateRank(topThreeSum, sum);
                    sum = 0;
                    continue;
                }
                sum += Integer.parseInt(line);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        long totalTopThree = topThreeSum[0] + topThreeSum[1] + topThreeSum[2];
        bw.write(String.valueOf(totalTopThree));
        bw.newLine();
        bw.flush();
        bw.close();
    }

    private void updateRank(long[] maxSum, long sum) {
        if (sum <= maxSum[2])
            return;
        if (sum <= maxSum[1]) {
            maxSum[2] = sum;
        }
        else if (sum <= maxSum[0]) {
            maxSum[2] = maxSum[1];
            maxSum[1] = sum;
        }
        else {
            maxSum[2] = maxSum[1];
            maxSum[1] = maxSum[0];
            maxSum[0] = sum;
        }
    }
}
