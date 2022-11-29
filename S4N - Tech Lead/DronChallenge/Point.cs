namespace Challenge
{
    public class Point
    {
        public const string OCCIDENTE = "Occidente";
        public const string ORIENTE = "Oriente";
        public const string SUR = "Sur";
        public const string NORTE = "Norte";

        public Point(int x, int y, string orientation)
        {
            X = x;
            Y = y;
            Orientation = orientation;
        }

        public int X { get; set; } = 0;

        public int Y { get; set; } = 0;

        public string Orientation { get; set; } = NORTE;

        public void Turn(char dir)
        {
            switch (Orientation)
            {
                case NORTE:
                    {
                        if (dir == 'I')
                            Orientation = OCCIDENTE;
                        else
                            Orientation = ORIENTE;
                    }
                    break;
                case SUR:
                    {
                        if (dir == 'I')
                            Orientation = ORIENTE;
                        else
                            Orientation = OCCIDENTE;
                    }
                    break;
                case ORIENTE:
                    {
                        if (dir == 'I')
                            Orientation = NORTE;
                        else
                            Orientation = SUR;
                    }
                    break;
                case "Occidente":
                    {
                        if (dir == 'I')
                            Orientation = SUR;
                        else
                            Orientation = NORTE;
                    }
                    break;
            }
        }

        public void Move()
        {
            switch (Orientation)
            {
                case NORTE:
                    {
                        Y += 1;
                    }
                    break;
                case SUR:
                    {
                        Y -= 1;
                    }
                    break;
                case ORIENTE:
                    {
                        X += 1;
                    }
                    break;
                case OCCIDENTE:
                    {
                        X -= 1;
                    }
                    break;
            }
        }

        public void Go(string route)
        {
            for (int x = 0; x < route.Length; x++)
            {
                char i = route[x];
                if (i == 'A')
                    Move();
                else Turn(i);
            }
        }

        public Point Clone()
        {
            return new Point(X, Y, Orientation);
        }
    }
}
