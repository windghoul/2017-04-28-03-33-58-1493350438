import java.util.Arrays;

/**
 * Created by Ghoul on 2017/5/3.
 */
public class BowlingGame {
    public int[] bowlingScore = new int[10];
    public int[] bowlingnum = new int[22];
    int countnum = 0;
    public int getBowlingScore(String bowlingCode) {
        int sum = 0;
        char[] bowling = bowlingCode.toCharArray();
        trunCodeToNum(bowling);
//        System.out.println(Arrays.toString(bowling));
        getScore(bowling);
        for (int i = 0; i < bowlingScore.length; i++) {
            sum += bowlingScore[i];
        }
        //System.out.println(sum);
        return sum;
    }
    public int trunCodeToNum(char[] bowling) {
        int j = 0;
//        System.out.println(bowling.length);
        for (int i = 0; i <bowling.length ; i++) {

            switch (bowling[i]) {
                case 'X':
                    bowlingnum[j] = 10;
                    j++;
                    continue;
                case '/':
                    bowlingnum[j] = 10 - bowlingnum[j - 1];
                    j++;
                    continue;
                case '-':
                    bowlingnum[j] = 0;
                    j++;
                    continue;
                case '|':
                    countnum++;
                    continue;
                default:
                    bowlingnum[j] = bowling[i] - '0';
                    j++;
                    continue;
            }
        }
//        System.out.println(countnum);
//        System.out.println(Arrays.toString(bowlingnum));
        return 0;
    }

    public void getScore(char[] bowling) {
        int j = 0;
        int count = 0;
        int midScore = 0;
//        System.out.println(bowling.length);
        for (int i = 0; i <bowling.length; i++) {
            if (bowling[i] != '|') {
                switch (bowling[i]) {
                    case 'X':
                        midScore = 10 + bowlingnum[i - count + 1] + bowlingnum[i - count + 2];
                        continue;
                    case '/':
                        midScore = 10 + bowlingnum[i - count + 1];
                        continue;
                    default:
                        midScore += bowlingnum[i - count];
                        continue;
                }
            }
            else {
                count++;
            }
            bowlingScore[j] = midScore;
            midScore = 0;
            j++;
            if (j == 10)
            break;
        }
//        System.out.println(Arrays.toString(bowlingScore));

    }
}
