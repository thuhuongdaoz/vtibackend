package vn.test.vtibackend.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vn.test.vtibackend.dto.request.GroupReq;
import vn.test.vtibackend.entity.Group;
import vn.test.vtibackend.service.GroupService;

import java.util.List;

@RestController
@RequestMapping("api/v1/groups")
@RequiredArgsConstructor
//@Validated
public class GroupController {
    private final GroupService groupService;

    @GetMapping("/exception")
    public void exception() {
        throw new RuntimeException("khooong bit");
    }
    @GetMapping
    public ResponseEntity<List<Group>> search(@RequestParam(required = false) String name) {
        List<Group> groups = groupService.search(name);
        return ResponseEntity.ok(groups);
    }
    @PostMapping
    public ResponseEntity<Group> create(@RequestBody @Valid GroupReq request){
        Group group = groupService.create(request);
        System.out.println(group);
        return ResponseEntity.ok(group);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Group> update(@PathVariable Integer id, @RequestBody @Valid GroupReq request){
        Group group = groupService.update(id, request);
        return ResponseEntity.ok(group);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        groupService.delete(id);
    }

}
