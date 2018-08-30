package guru.springframework.sftpetclinic.model;

import java.util.Set;

public class Vet extends Person {

    private Set<Speciality> Specialities;

    public Set<Speciality> getSpecialities() {
        return Specialities;
    }

    public void setSpecialities(Set<Speciality> specialities) {
        Specialities = specialities;
    }
}
