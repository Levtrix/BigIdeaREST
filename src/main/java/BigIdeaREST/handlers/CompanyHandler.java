package BigIdeaREST.handlers;

import BigIdeaDAL.repository.CompanyRepository;
import BigIdeaREST.response.CompanyJson;
import BigIdeaREST.response.ErrorJson;
import BigIdeaREST.response.Reply;
import BigIdeaREST.response.Status;
import com.google.gson.Gson;
import logging.Logger;
import models.Company;

import java.util.ArrayList;
import java.util.List;

public class CompanyHandler implements ICompanyHandler {
    private CompanyRepository companyRepository;
    private Gson gson;

    public CompanyHandler(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
        this.gson = new Gson();

        // Lets Hibernate create a database connection during server startup
        companyRepository.findAll();
    }

    @Override
    public Reply getCompanies() {
        try {
            //addCompanies();
            List<CompanyJson> companyResponse = new ArrayList<>();

            for (Company c : companyRepository.findAll()) {
                companyResponse.add(new CompanyJson(c.getId(), c.getName(), c.getPostalCode(), c.getAddress()));
            }

            String json = gson.toJson(companyResponse);
            return new Reply(Status.OK, json);
        } catch (Exception e) {
            Logger.getInstance().log(e);
            ErrorJson errorJson = new ErrorJson("Something went wrong");

            return new Reply(Status.ERROR, gson.toJson(errorJson));
        }
    }

    @Override
    public Reply getCompany(int companyId) {
        Company company = companyRepository.findOne(companyId);

        if (company != null) {
            String json = gson.toJson(company);

            return new Reply(Status.OK, json);
        }

        ErrorJson errorJson = new ErrorJson("Something went wrong");
        return new Reply(Status.ERROR, gson.toJson(errorJson));
    }

    @Override
    public Reply saveCompany(Company company) {
        Company saved = companyRepository.save(company);

        if (saved.getId() == company.getId()) {
            return new Reply(Status.OK, gson.toJson(saved));
        }

        ErrorJson errorJson = new ErrorJson("Something went wrong");
        return new Reply(Status.ERROR, gson.toJson(errorJson));
    }

    @Override
    public Reply deleteCompany(int companyId) {
        try {
            companyRepository.delete(companyId);
            ErrorJson messageJson = new ErrorJson("Deleted");

            return new Reply(Status.OK, gson.toJson(messageJson));
        } catch (Exception e) {
            ErrorJson errorJson = new ErrorJson("Something went wrong");

            return new Reply(Status.ERROR, gson.toJson(errorJson));
        }
    }

    private void addCompanies() {
        //TODO: Add test company data
    }
}
