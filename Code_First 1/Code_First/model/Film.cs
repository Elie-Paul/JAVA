using System.Collections.Generic;

namespace Code_First.model
{
    public class Film
    {
        public int FilmId { get; set; }
        public string FilmTitle { get; set; }
        public string Description { get; set; }
        public int release_year { get; set; }
        public int rental_duration { get; set; }
        public int rental_rate { get; set; }
        public int lenght { get; set; }
        public int rental { get; set; }

        public ICollection<Store> stores { get; set; }
     
    }
}