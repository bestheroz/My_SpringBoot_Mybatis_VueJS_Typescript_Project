package com.github.bestheroz.standard.common.code;

import com.github.bestheroz.demo.api.entity.code.TableCodeRepository;
import com.github.bestheroz.standard.common.util.AuthenticationUtils;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class CodeService {
  @Resource private TableCodeRepository tableCodeRepository;

  public List<CodeVO> getCodeVOListByAuthority(final String codeGroup) {
    final Integer authority = AuthenticationUtils.getLoginVO().getAuthority();
    return this.tableCodeRepository
        .getItemsByKeyWithOrder(Map.of("codeGroup", codeGroup), List.of("displayOrder"))
        .stream()
        .filter(item -> item.isAvailable() && item.getAuthority() <= authority)
        .map(item -> new CodeVO(item.getCode(), item.getName()))
        .collect(Collectors.toList());
  }

  public List<CodeVO> getCodeVOList(final String codeGroup) {
    return this.tableCodeRepository
        .getItemsByKeyWithOrder(Map.of("codeGroup", codeGroup), List.of("displayOrder"))
        .stream()
        .map(item -> new CodeVO(item.getCode(), item.getName()))
        .collect(Collectors.toList());
  }
}
