using System;
using System.Collections.Generic;
using System.IO;

namespace Challenge
{
    public class ReportOutput
    {
        private string OutPath {get; set;}
        private List<Point> Content {get; set; }

        public ReportOutput(string path, List<Point> content)
        {
            OutPath = path;
            Content = content;
        }

        public void CreateReport()
        {
            int i = 0;
            string[] linesOut = new string[Content.Count+1];

            linesOut[i++] = String.Format("== Reporte de entregas =={0}", System.Environment.NewLine);
            
            foreach (Point p in Content)
            {
                linesOut[i++] = String.Format("({0}, {1}) dirección {2}{3}", p.X, p.Y, p.Orientation, System.Environment.NewLine);

            }

            File.WriteAllLinesAsync(OutPath, linesOut);
        }
    }
}
