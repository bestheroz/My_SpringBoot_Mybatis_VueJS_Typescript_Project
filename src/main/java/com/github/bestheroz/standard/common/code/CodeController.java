package com.github.bestheroz.standard.common.code;

import com.github.bestheroz.standard.common.response.ApiResult;
import com.github.bestheroz.standard.common.response.Result;
import com.github.bestheroz.standard.common.util.AuthenticationUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("api/codes")
public class CodeController {
    @Resource private CodeDAO codeDAO;

    @GetMapping(value = "{codeGroup}")
    @Cacheable(value = "CodeVO", key = "#codeGroup")
    public ResponseEntity<ApiResult> getCodeVOList(@PathVariable(value = "codeGroup") final String codeGroup) {
        return Result.ok(this.codeDAO.getCodeVOList(codeGroup, AuthenticationUtils.getLoginVO().getAuthority()));
    }
}
