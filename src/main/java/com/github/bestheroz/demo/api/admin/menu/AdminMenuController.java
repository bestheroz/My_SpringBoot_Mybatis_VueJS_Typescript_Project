package com.github.bestheroz.demo.api.admin.menu;

import com.github.bestheroz.demo.api.entity.menu.TableMenuEntity;
import com.github.bestheroz.demo.api.entity.menu.TableMenuRepository;
import com.github.bestheroz.demo.api.menu.MenuService;
import com.github.bestheroz.standard.common.response.ApiResult;
import com.github.bestheroz.standard.common.response.Result;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping(value = "api/admin/menus")
public class AdminMenuController {
    @Resource private MenuService menuService;
    @Resource private AdminMenuService adminMenuService;
    @Resource private TableMenuRepository tableMenuRepository;

    @GetMapping
    ResponseEntity<ApiResult> getItems() {
        return Result.ok(this.menuService.getMenuList());
    }

    @GetMapping(value = "{id}")
    ResponseEntity<ApiResult> getItem(@PathVariable(value = "id", required = false) final Integer id) {
        return Result.ok(this.tableMenuRepository.getItem(TableMenuEntity.class, Map.of("id", id)));
    }

    @PostMapping
    @CacheEvict(value = "drawerCache", allEntries = true)
    public ResponseEntity<ApiResult> insert(@RequestBody final TableMenuEntity tableMenuEntity) {
        this.tableMenuRepository.insert(tableMenuEntity);
        return Result.created();
    }

    @PatchMapping(value = "{id}")
    @CacheEvict(value = "drawerCache", allEntries = true)
    public ResponseEntity<ApiResult> update(@PathVariable(value = "id") final Integer id, @RequestBody final TableMenuEntity tableMenuEntity) {
        this.tableMenuRepository.update(tableMenuEntity, Map.of("id", id));
        return Result.ok();
    }

    @DeleteMapping(value = "{id}")
    @CacheEvict(value = "drawerCache", allEntries = true)
    public ResponseEntity<ApiResult> delete(@PathVariable(value = "id") final Integer id) {
        this.adminMenuService.delete(id);
        return Result.ok();
    }
}