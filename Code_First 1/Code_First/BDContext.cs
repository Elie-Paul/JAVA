using Code_First.model;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Code_First
{
    public class BDContext : DbContext
    {
        public DbSet<Film> Films { get; set; }
        public DbSet<Store> Stores { get; set; }
        public DbSet<Adresse> Adresses { get; set; }
        public BDContext():base("name=filmContext")
        {
            Database.SetInitializer<BDContext>(new DropCreateDatabaseIfModelChanges<BDContext>());
        }
    }
}
