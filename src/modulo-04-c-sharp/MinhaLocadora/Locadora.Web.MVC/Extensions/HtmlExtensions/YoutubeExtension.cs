using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace System.Web.Mvc.Html
{
    public static class YoutubeExtension
    {
        private const string WIDTH = "width = '100%' ";
        private const string HEIGHT = "height = '500' " ;
        private const string FRAMEBORDER = "frameborder='10' ";
        private const string ALLOW_FULLSCREEN = "allowfullscreen";

        private const string TAG_START = "<iframe " + WIDTH + HEIGHT;
        private const string TAG_END = FRAMEBORDER + ALLOW_FULLSCREEN + "></iframe>";

        
        public static MvcHtmlString EmbedVideo(this HtmlHelper helper, string url)
        {
            string src;
            string fullString;

            if (url != null)
            {
                var indice = url.Length - 11;

                var videoCode = url.Substring(indice, 11);

                src = "src=\"https://www.youtube.com/embed/" + videoCode + "\" ";

                fullString = TAG_START + src + TAG_END;
            }
            else
            {
                src = "src=''";

                fullString = TAG_START + src + TAG_END;
            }

            return new MvcHtmlString(fullString);
        }
    }
}