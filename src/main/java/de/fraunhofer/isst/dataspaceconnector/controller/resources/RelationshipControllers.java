package de.fraunhofer.isst.dataspaceconnector.controller.resources;

import de.fraunhofer.isst.dataspaceconnector.model.Agreement;
import de.fraunhofer.isst.dataspaceconnector.model.Artifact;
import de.fraunhofer.isst.dataspaceconnector.model.Contract;
import de.fraunhofer.isst.dataspaceconnector.model.ContractRule;
import de.fraunhofer.isst.dataspaceconnector.model.OfferedResource;
import de.fraunhofer.isst.dataspaceconnector.model.Representation;
import de.fraunhofer.isst.dataspaceconnector.model.RequestedResource;
import de.fraunhofer.isst.dataspaceconnector.model.view.AgreementView;
import de.fraunhofer.isst.dataspaceconnector.model.view.ArtifactView;
import de.fraunhofer.isst.dataspaceconnector.model.view.ContractRuleView;
import de.fraunhofer.isst.dataspaceconnector.model.view.ContractView;
import de.fraunhofer.isst.dataspaceconnector.model.view.OfferedResourceView;
import de.fraunhofer.isst.dataspaceconnector.model.view.RepresentationView;
import de.fraunhofer.isst.dataspaceconnector.services.resources.RelationshipServices;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.UUID;

public final class RelationshipControllers {

    @RestController
    @RequestMapping("/api/rules/{id}/contracts")
    @Tag(name = "Rules", description = "Endpoints for linking rules to contracts")
    public static class RulesToContracts extends BaseResourceChildController<RelationshipServices.RuleContractLinker, ContractRule, ContractRuleView> {
    }

    @RestController
    @RequestMapping("/api/artifacts/{id}/representations")
    @Tag(name = "Artifacts", description = "Endpoints for linking artifacts to representations")
    public static class ArtifactsToRepresentations extends BaseResourceChildController<RelationshipServices.ArtifactRepresentationLinker, Artifact, ArtifactView> {
    }

    @RestController
    @RequestMapping("/api/representations/{id}/offers")
    @Tag(name = "Representations", description = "Endpoints for linking representations to offered resources")
    public static class RepresentationsToOfferedResources extends BaseResourceChildController<RelationshipServices.RepresentationOfferedResourceLinker, Representation, RepresentationView> {
    }

    @RestController
    @RequestMapping("/api/representations/{id}/requests")
    @Tag(name = "Representations", description = "Endpoints for linking representations to requested resources")
    public static class RepresentationsToRequestedResources extends BaseResourceChildController<RelationshipServices.RepresentationOfferedResourceLinker, Representation, RepresentationView> {
    }

    @RestController
    @RequestMapping("/api/offers/{id}/catalogs")
    @Tag(name = "Resources", description = "Endpoints for linking offered resources to catalogs")
    public static class OfferedResourcesToCatalogs extends BaseResourceChildController<RelationshipServices.OfferedResourceCatalogLinker, OfferedResource, OfferedResourceView> {
    }

    @RestController
    @RequestMapping("/api/requests/{id}/catalogs")
    @Tag(name = "Resources", description = "Endpoints for linking requested resources to catalogs")
    public static class RequestedResourcesToCatalogs extends BaseResourceChildController<RelationshipServices.RequestedResourceCatalogLinker, RequestedResource, OfferedResourceView> {
    }

    @RestController
    @RequestMapping("/api/contracts/{id}/offers")
    @Tag(name = "Contracts", description = "Endpoints for linking contracts to offers")
    public static class ContractsToOfferedResources extends BaseResourceChildController<RelationshipServices.ContractOfferedResourceLinker, Contract, ContractView> {
    }

    @RestController
    @RequestMapping("/api/contracts/{id}/requests")
    @Tag(name = "Contracts", description = "Endpoints for linking contracts to requests")
    public static class ContractsToRequestedResources extends BaseResourceChildController<RelationshipServices.ContractRequestedResourceLinker, Contract, ContractView> {
    }

    @RestController
    @RequestMapping("/api/artifacts/{id}/agreements")
    @Tag(name = "Artifacts", description = "Endpoints for linking artifacts to agreements")
    public static class ArtifactsToAgreements extends BaseResourceChildController<RelationshipServices.AgreementArtifactLinker, Artifact, ArtifactView> {
        @Override
        @Hidden
        @ApiResponses(value = {@ApiResponse(responseCode = "405", description = "Not allowed")})
        public HttpEntity<PagedModel<ArtifactView>> addResources(
                @Valid @PathVariable(name = "id") final UUID ownerId,
                @Valid @RequestBody final List<URI> resources) {
            return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
        }

        @Override
        @Hidden
        @ApiResponses(value = {@ApiResponse(responseCode = "204", description = "No content")})
        public HttpEntity<Void> replaceResources(@Valid @PathVariable(name = "id") final UUID ownerId,
                                                 @Valid @RequestBody final List<URI> resources) {
            return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
        }

        @Override
        @Hidden
        @ApiResponses(value = {@ApiResponse(responseCode = "204", description = "No content")})
        public HttpEntity<Void> removeResources(@Valid @PathVariable(name = "id") final UUID ownerId,
                                                @Valid @RequestBody final List<URI> resources) {
            return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

    @RestController
    @RequestMapping("/api/agreements/{id}/artifacts")
    @Tag(name = "Agreements", description = "Endpoints for linking agreements to artifacts")
    public static class AgreementsToArtifacts extends BaseResourceChildController<RelationshipServices.ArtifactAgreementLinker, Agreement, AgreementView> {
        @Override
        @Hidden
        @ApiResponses(value = {@ApiResponse(responseCode = "405", description = "Not allowed")})
        public HttpEntity<PagedModel<AgreementView>> addResources(
                @Valid @PathVariable(name = "id") final UUID ownerId,
                @Valid @RequestBody final List<URI> resources) {
            return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
        }

        @Override
        @Hidden
        @ApiResponses(value = {@ApiResponse(responseCode = "204", description = "No content")})
        public HttpEntity<Void> replaceResources(@Valid @PathVariable(name = "id") final UUID ownerId,
                                                 @Valid @RequestBody final List<URI> resources) {
            return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
        }

        @Override
        @Hidden
        @ApiResponses(value = {@ApiResponse(responseCode = "204", description = "No content")})
        public HttpEntity<Void> removeResources(@Valid @PathVariable(name = "id") final UUID ownerId,
                                                @Valid @RequestBody final List<URI> resources) {
            return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
        }
    }
}
