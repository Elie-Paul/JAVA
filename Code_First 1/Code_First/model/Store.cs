using System.Collections;
using System.Collections.Generic;

namespace Code_First.model
{
    public class Store
    {
        public int StoreId { get; set; }
        public ICollection<Adresse> adresses { get; set; }
        public ICollection<Film> films { get; set; }
    }
}