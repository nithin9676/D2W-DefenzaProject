package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Dao.Admindao;
import com.entity.AdminEntity;
import com.exception.RoleAlreadyExist;
import com.exception.RoleNotfounException;

@Service
public class AdminService {
	@Autowired
	Admindao admindao;
	@Autowired
	PasswordEncoder passwordEncoder;
	
			public String insertingAdminDetails(AdminEntity admindetails, String loggedEmail) {

				// check email already exists or not
				Optional<AdminEntity> existing = admindao.findingemailid(admindetails.getEmail());
				if (existing.isPresent()) {
					throw new RoleNotfounException("Email already used");
				}

				// get all admins/users count
				List<AdminEntity> allUsers = admindao.getalldetails();
				int count = allUsers.size();

				// FIRST USER CREATION
				if (count == 0) {

					// first user must be OWNER
					if (!admindetails.getDesgination().equalsIgnoreCase("OWNER")) {
						throw new RoleNotfounException("First user must be OWNER");
					}

					admindetails.setPassword(passwordEncoder.encode(admindetails.getPassword()));
					admindao.insertingdetails(admindetails);

					return "First OWNER created successfully";
				}

				// AFTER FIRST USER, loggedEmail is required
				if (loggedEmail == null || loggedEmail.isBlank()) {
					throw new RoleNotfounException("Logged email is required");
				}

				// find logged in user
				Optional<AdminEntity> loggeduser = admindao.findingemailid(loggedEmail);
				if (!loggeduser.isPresent()) {
					throw new RoleNotfounException("Logged user not found");
				}

				// only OWNER can create new users
				if (!loggeduser.get().getDesgination().equalsIgnoreCase("OWNER")) {
					throw new RoleNotfounException("Only OWNER can create new ADMIN or OWNER");
				}

				// new user role must be OWNER or ADMIN
				if (!admindetails.getDesgination().equalsIgnoreCase("OWNER")
						&& !admindetails.getDesgination().equalsIgnoreCase("ADMIN")) {
					throw new RoleNotfounException("Role must be OWNER or ADMIN");
				}

				admindetails.setPassword(passwordEncoder.encode(admindetails.getPassword()));
				admindao.insertingdetails(admindetails);

				return "Admin/Owner registered successfully";
			}

			public AdminEntity adminlogin(String email, String password) {
				Optional<AdminEntity> admin = admindao.findingemailid(email);

				if (!admin.isPresent()) {
					throw new RoleAlreadyExist("User not found");
				}

				if (!passwordEncoder.matches(password, admin.get().getPassword())) {
					throw new RoleAlreadyExist("Invalid Username or Password");
				}

				return admin.get();
			}

			public String deletingAdmin(String adminemail, String logedemail) {

				Optional<AdminEntity> logeduser = admindao.findingemailid(logedemail);
				if (!logeduser.isPresent()) {
					throw new RoleNotfounException("Logged user is not present");
				}

				if (!logeduser.get().getDesgination().equalsIgnoreCase("OWNER")) {
					throw new RoleNotfounException("Only OWNER can delete admins");
				}

				Optional<AdminEntity> adminfound = admindao.findingemailid(adminemail);
				if (!adminfound.isPresent()) {
					throw new RoleNotfounException("Admin not present");
				}

				if (!adminfound.get().getDesgination().equalsIgnoreCase("ADMIN")) {
					throw new RoleNotfounException("OWNER cannot be deleted");
				}

				admindao.deletingAdmin(adminfound.get());
				return "Admin deleted successfully";
			}

			public List<AdminEntity> getadimindetails() {
				return admindao.getalldetails();
			}
		}