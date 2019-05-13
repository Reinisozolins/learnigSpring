package lv.ozo.learningSpring.controller;

import lv.ozo.learningSpring.entity.IssueReport;
import lv.ozo.learningSpring.repository.IssueRepository;
import lv.ozo.learningSpring.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class IssueController {
    @Autowired
    private IssueService issueService;


    @GetMapping("/issuereport")
    public String getReport(Model model, @RequestParam(name = "submitted", required = false) boolean submitted) {
        model.addAttribute("issuereport", new IssueReport());
        model.addAttribute("submitted", submitted);
        return "issues/issuereport_form";
    }

    @PostMapping(value = "/issuereport")
    public String submitReport(@Valid @ModelAttribute ("issuereport") IssueReport issueReport, BindingResult result,
                               Model model, RedirectAttributes ra) {
        if (result.hasErrors()){
            return "issues/issuereport_form";
        }
        this.issueService.save(issueReport);
        ra.addAttribute("submitted", true);
        return "redirect:/issuereport";
    }

    @GetMapping("/issues")
    public String getIssues(Model model) {
        model.addAttribute("issues", this.issueService.getAllIssues());
        return "issues/issuereport_list";
    }

    @GetMapping("/restricted/issues")
    public String getRestricedIssues(Model model) {
        model.addAttribute("issues", this.issueService.getPublicIssues());
        return "issues/issuereport_list";
    }
    @GetMapping("/issuereport/delete/{id}")
    public String getReport (Model model, @PathVariable("id")Optional<IssueReport> issueReport){
        issueReport.ifPresent(issue -> this.issueService.delete(issue));
        return  "redirect:/issues";
    }
    @GetMapping ("/issuereport/update/{id}")
    public String updateIssue (Model model, @PathVariable("id")Optional<IssueReport> issueReport){
        issueReport.ifPresent(issue -> model.addAttribute("issuereport", issue));
        return "issues/issuereport_form";
    }
}