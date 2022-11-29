using System;
using System.Collections.Generic;
using System.IO;

namespace Challenge
{

    public class Program
    {
    
        static void Main(string[] args)
        {
            Console.Write("Enter input file: ");
            string input = Console.ReadLine();

            string[] lines = File.ReadAllLines(input);
            List<Point> traced = new List<Point>();

            

            Point p = new Point(0, 0, Point.NORTE);

            foreach (string line in lines)
            {
                p.Go(line);
                traced.Add(p.Clone());
                
            }

            string output = input.Replace("in", "out");
            ReportOutput report = new ReportOutput(output, traced);
            report.CreateReport();
        }
    }
}
