using System;
using System.Collections.Generic;

namespace SHLAmazonChallenge
{
    public class Program
    {
        public int[] cellCompete(int[] states, int days)
        {
            int[] retstates = new int[states.Length];
            // INSERT YOUR CODE HERE
            for (int y = 0; y < days; y++)
            {
                for (int x = 0; x < states.Length; x++)
                {
                    int before;
                    int after;
                    if (x == 0)
                    {
                        before = 0;
                        after = states[x + 1];
                    }
                    else if ( x == states.Length - 1)
                    {
                        after = 0;
                        before = states[x - 1];
                    }
                    else
                    {
                        before = states[x - 1];
                        after = states[x + 1];
                    }

                    if((before == 0 && after == 0) || (before == 1 && after == 1))
                    {
                        retstates[x] = 0;
                    }
                    else
                    {
                        retstates[x] = 1;
                    }
                }
                retstates.CopyTo(states,0);
            }

            return states;
        }

        public int generalizedGCD(int num, int[] arr)
        {
            //Buscamos el mínimo
            int min = arr[0];
            for(int x = 0; x< num; x++)
            {
                if (arr[x] < min)
                    min = arr[x];
            }

            int res = 1;
            //Verificamos si se puede dividir
            while (true)
            {
                for (int x = 0; x < num; x++)
                {
                    res = arr[x] % min;

                    if (res != 0)
                        break;
                }

                if (res == 0)
                    break;

                min -= 1;

            }


            return min;
        }

        public long getNumberOfOptions(List<int> priceOfJeans, List<int> priceOfShoes, List<int> priceOfSkirts, List<int> priceOfTops, int dollars)
        {
            int resp = 0;

            int sum = 0;

            for (int jeans = 0; jeans < priceOfJeans.Count; jeans++)
            {

                sum = 0;
                sum += priceOfJeans[jeans];

                for (int shoes = 0; shoes < priceOfShoes.Count; shoes++)
                {

                    if (shoes > 0)
                        sum = sum - priceOfShoes[shoes - 1];

                    sum += priceOfShoes[shoes];

                    for (int skirts = 0; skirts < priceOfSkirts.Count; skirts++)
                    {

                        if (skirts > 0)
                            sum = sum - priceOfSkirts[skirts - 1];

                        sum += priceOfSkirts[skirts];

                        for (int tops = 0; tops < priceOfTops.Count; tops++)
                        {

                            if (tops > 0)
                                sum = sum - priceOfTops[tops - 1];

                            sum += priceOfTops[tops];

                            if (sum <= dollars)
                                resp += 1;

                            if (tops > 0)
                                sum = sum - priceOfTops[tops - 1];

                        }

                        if (skirts > 0)
                            sum = sum - priceOfSkirts[skirts - 1];

                    }

                    if (shoes > 0)
                        sum = sum - priceOfShoes[shoes - 1];

                }

        }





            return resp;
        }

        public List<string> doesCircleExist(List<string> commands)
        {
            List<string> ret = new List<string>();

            for (int x = 1; x < commands.Count; x++)
            {
                bool r = false;
                string command = commands[x] + commands[x] + commands[x] + commands[x];

                int c = 0;
                char t = ' ';
                for (int y = 0; y < command.Length; y++)
                {

                    if (command[y] == 'L' || command[y] == 'R')
                    {
                        if (t == ' ')
                        {
                            t = command[y];
                            c += 1;
                        }
                        else
                        {
                            if (t == command[y])
                            {
                                c += 1;
                            }
                            else
                            {
                                t = command[y];
                                c = 0;
                            }
                        }
                    }

                    if (c == 4)
                    {
                        ret.Add("YES");
                        break;
                    }
                }
                if (c != 4)
                    ret.Add("NO");
            }

            return ret;

        }

        static void Main(string[] args)
        {
            Program p = new Program();
            //int[] states = { 1, 1, 1, 0, 1, 1, 1, 1 };
            //p.cellCompete(states, 2);
            //int[] input = { 2, 4, 6, 8, 10 };
            //p.generalizedGCD(5, input);

            List<int> a = new List<int>{ 2, 3 };
            List<int> b = new List<int>{ 4 };
            List<int> c = new List<int>{ 2 };
            //List<int> d = new List<int>{ 1, 2, 3 };

            //p.getNumberOfOptions(a,b,c,d,10);
            List<String> d = new List<String> { "2", "G", "L" };

            p.doesCircleExist(d);






        }
    }
}
