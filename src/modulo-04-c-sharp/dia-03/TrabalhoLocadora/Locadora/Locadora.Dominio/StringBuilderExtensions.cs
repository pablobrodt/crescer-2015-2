using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio
{
    public static class StringBuilderExtensions
    {
        public static void AddSpaces(this StringBuilder builder, int quantidade)
        {
            for (int i = 0; i < quantidade; i++)
            {
                builder.Append(" ");
            }
        }

        public static void BreakLine(this StringBuilder builder)
        {
            builder.Append("\r\n");
        }

        public static void AddHorizontalSeparator(this StringBuilder builder, int quantidade, string caractereSeparador)
        {   
            if(caractereSeparador.Length == 1)
            {
                for (int i = 0; i < quantidade; i++)
                {
                    builder.Append(caractereSeparador);
                }
            }
        }
    }
}
