package com.app.service;

import com.app.dto.SuccessMessageDto;
import com.app.pojos.Company;

public interface IAdminService {
    SuccessMessageDto  addCompany(Company company);
}
