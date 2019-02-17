package BigIdeaDAL.repository;

import models.Company;

public class CompanyRepository extends AbstractRepository<Company, Integer> {
    @Override
    public Class<Company> getDomainClass() {
        return Company.class;
    }
}
