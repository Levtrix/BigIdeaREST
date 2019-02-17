package BigIdeaREST.handlers;

import BigIdeaREST.response.Reply;
import models.Company;

public interface ICompanyHandler {
    Reply getCompanies();
    Reply getCompany(int companyId);
    Reply saveCompany(Company company);
    Reply deleteCompany(int companyId);
}
