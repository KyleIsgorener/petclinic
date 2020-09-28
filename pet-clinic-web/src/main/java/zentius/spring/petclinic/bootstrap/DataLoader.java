package zentius.spring.petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import zentius.petclinic.model.Owner;
import zentius.petclinic.model.Vet;
import zentius.petclinic.services.OwnerService;
import zentius.petclinic.services.VetService;


@Component
public class DataLoader implements CommandLineRunner {


    private final VetService vetService;
    private final OwnerService ownerService;

    // After Spring 4.2 you don't need to use autowired annotation because it is implemented automatically
    public DataLoader(VetService vetService, OwnerService ownerService) {
        this.vetService = vetService;
        this.ownerService = ownerService;
    }

    /*
    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }
    */


    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        String name1 = ownerService.findById(1L).getFirstName();
        String name2 = ownerService.findById(2L).getFirstName();

        System.out.println(name1 + ' ' + name2);

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jesse");
        vet2.setLastName("Porter");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");

    }
}
