docker tag ${image_id} ${aws_account_id}.dkr.ecr.${region}.amazonaws.com/${repository-name}:${image_tag}

docker push ${aws_account_id}.dkr.ecr.${region}.amazonaws.com/${repository-name}