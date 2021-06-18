package net.kodar.kafka.services.mapper;

import net.kodar.kafka.data.entity.IHelpEntity;
import net.kodar.protobuf.IHelpEntityProtos;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IHelpEntityMapper {

  IHelpEntity protoToEntity(IHelpEntityProtos.IHelpEntity entityProto);
}
