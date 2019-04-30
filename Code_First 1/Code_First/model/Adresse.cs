using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Code_First.model
{
    public class Adresse
    {
        public int AdresseId {get;set;}
        public String adresse { get; set; }
        public String phone { get; set; }

        public ICollection<Store> stores { get; set; }
    }
}
