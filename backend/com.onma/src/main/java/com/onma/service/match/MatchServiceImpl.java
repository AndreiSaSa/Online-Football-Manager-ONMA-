package com.onma.service.match;

import com.onma.model.match.MatchModel;
import com.onma.service.base.AbstractServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MatchServiceImpl extends AbstractServiceImpl<MatchModel> implements MatchService {
}
